# CustomButtonsAndroid
[![](https://jitpack.io/v/bachiri/CustomButtonsAndroid.svg)](https://jitpack.io/#bachiri/CustomButtonsAndroid)
A library containing some custom useful Buttons using The Kotlin language ,this is the first version ,stay tuned and check the library for more custom buttons.<br/>
<img src="https://github.com/bachiri/CustomButtonsAndroid/blob/master/img/Icon.png" align="center" width="168px" height="168px"/>

### Download
1. Add below code in your root build.gradle at the end of repositories
```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
2. Add the dependency
```groovy
dependencies {
     compile 'com.github.bachiri:CustomButtonsAndroid:0.1.0'
}
```

### Sample application
You can check the sample code that uses this Library in [sample application](https://github.com/bachiri/CustomButtonsAndroid/tree/master/app).

```xml
<io.bachirio.custombuttons.CustomButton
        android:layout_width="60dp"
        android:layout_height="60dp"
        app:pressed_color="@color/custom_fab_Button_pressed"
        app:round_radius="50dp"
        app:btn_shape_type="circle"
        app:unpressed_color="@color/custom_fab_Button_unpressed"
        />
```

![alt text](https://github.com/bachiri/CustomButtonsAndroid/blob/master/img/LibrayScreenImage.png)

### Contributing
>   you can *Contribute* to this project by forking it or sending  a pull request.
