Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.Deep1210:customWebview:1.0'
	}


**USAGE:** 
```
Intent intent  = new Intent( "Your Activity instance", CustomWebview.class);
intent.putExtra("url","https://google.com");
startActivity(intent);
```
