package com.example.myapplication.di.module


import com.example.myapplication.presenter.SignInPresenter
import com.example.myapplication.presenter.impl.SignInPresenterImpl
import com.example.myapplication.views.SplashLogInView
import com.example.myapplication.views.activities.SplashLoginActivity
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(includes = [AuthenticationModule.Declarations::class])
object AuthenticationModule {

  @Provides
  @JvmStatic
  fun splashLoginView(splashLoginActivity: SplashLoginActivity) : SplashLogInView = splashLoginActivity

//  @Provides
//  @JvmStatic
//  fun signInView(signInActivity: SignInActivity): SignInView = signInActivity
//
//  @Provides
//  @JvmStatic
//  fun registrationView(registrationContainerView: RegistrationActivity):
//      RegistrationContainerView = registrationContainerView
//
//  @Provides
//  @JvmStatic
//  fun updatePasswordView(updatePasswordActivity: UpdatePasswordActivity):
//      UpdatePasswordContainerView = updatePasswordActivity
//
//  @Provides
//  @JvmStatic
//  fun updatePhoneView(updatePhoneContainerView: UpdatePhoneNumberActivity):
//      UpdatePhoneContainerView = updatePhoneContainerView

  @Module
  interface Declarations {

    @Binds
    fun provideSplashLogInPresenter(signInPresenterImpl: SignInPresenterImpl) : SignInPresenter

//    @Binds
//    fun provideSignInPresenter(
//      signInPresenterImpl:
//      SignInPresenterImpl
//    ): SignInPresenter
//
//    @Binds
//    fun registrationPresenter(
//      registrationPresenterImpl: RegistrationPresenterImpl
//    ): RegistrationPresenter
//
//    @Binds
//    fun updatePasswordPresenter(
//      updatePasswordPresenterImpl: UpdatePasswordPresenterImpl
//    ): UpdatePasswordPresenter
//
//    @Binds
//    fun updatePhonePresenter(
//      updatePhonePresenterImpl: UpdatePresenterImpl
//    ): UpdatePhonePresenter
//
//    @Binds
//    fun registrationInteract(
//      registrationInteractImpl:
//      AuthenticationInteractImpl
//    ): AuthenticationInteract
  }
}