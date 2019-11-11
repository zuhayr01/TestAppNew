package com.example.testapp.viewmodels;

import android.text.TextUtils;
import android.util.Patterns;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.testapp.models.User;

public class LoginViewModel extends BaseObservable {
    private User user;


    private String successMessage = "Login was successful";
    private String errorMessage = "Email or Password not valid";

    @Bindable
    private String toastMessage = null;


    public String getToastMessage() {
        return toastMessage;
    }


    private void setToastMessage(String toastMessage) {

        this.toastMessage = toastMessage;
        notifyPropertyChanged(com.example.testapp.BR.toastMessage);
    }


    public void setUserEmail(String email) {
        user.setEmail(email);
        notifyPropertyChanged(com.example.testapp.BR.userEmail);
    }

    @Bindable
    public String getUserEmail() {
        return user.getEmail();
    }

    @Bindable
    public String getUserPassword() {
        return user.getPassword();
    }

    public void setUserPassword(String password) {
        user.setPassword(password);
        notifyPropertyChanged(com.example.testapp.BR.userPassword);
    }

    public LoginViewModel() {
        user = new User("","");
    }

    public void onLoginClicked() {
        if (isInputDataValid())
            setToastMessage(successMessage);
        else
            setToastMessage(errorMessage);
    }

    public boolean isInputDataValid() {
        return !TextUtils.isEmpty(getUserEmail()) && Patterns.EMAIL_ADDRESS.matcher(getUserEmail()).matches() && getUserPassword().length() > 5;
    }
}

