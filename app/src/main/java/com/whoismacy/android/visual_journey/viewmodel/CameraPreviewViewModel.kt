package com.whoismacy.android.visual_journey.viewmodel

import android.content.Context
import android.util.Log
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.ImageProxy
import androidx.camera.core.Preview
import androidx.camera.core.SurfaceRequest
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.lifecycle.awaitInstance
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.awaitCancellation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

private const val TAG = "CAMERAPREVIEWVIEWMODEL"

@HiltViewModel
class CameraPreviewViewModel
    @Inject
    constructor() : ViewModel() {
        private val _surfaceRequest = MutableStateFlow<SurfaceRequest?>(null)
        val surfaceRequest: StateFlow<SurfaceRequest?> = _surfaceRequest

        private val cameraImageCaptureUseCase =
            ImageCapture
                .Builder()
                .apply {
                    setCaptureMode(ImageCapture.CAPTURE_MODE_MINIMIZE_LATENCY)
                    setFlashMode(ImageCapture.FLASH_MODE_AUTO)
                }.build()

        private val cameraPreviewUseCase =
            Preview
                .Builder()
                .build()
                .apply {
                    setSurfaceProvider { newSurfaceRequest ->
                        _surfaceRequest.update { newSurfaceRequest }
                    }
                }

        suspend fun bindToCamera(
            appContext: Context,
            lifeCycleOwner: LifecycleOwner,
        ) {
            val processCameraProvider = ProcessCameraProvider.awaitInstance(appContext)
            processCameraProvider.bindToLifecycle(
                lifeCycleOwner,
                CameraSelector.DEFAULT_BACK_CAMERA,
                cameraPreviewUseCase,
                cameraImageCaptureUseCase,
            )

            try {
                awaitCancellation()
            } finally {
                processCameraProvider.unbindAll()
            }
        }

        fun capturePhoto(context: Context) {
            val executor = ContextCompat.getMainExecutor(context)
            cameraImageCaptureUseCase.takePicture(
                executor,
                object : ImageCapture.OnImageCapturedCallback() {
                    override fun onCaptureSuccess(image: ImageProxy) {
                        super.onCaptureSuccess(image)
                        image.close()
                    }

                    override fun onError(exception: ImageCaptureException) {
                        super.onError(exception)
                        exception.message?.let { Log.d(TAG, it) }
                    }
                },
            )
        }
    }
