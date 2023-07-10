package com.torrydo.screenez_test

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.torrydo.screenez.ScreenEz
import com.torrydo.screenez_test.ui.theme.Screenez_testTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ScreenEz.setup(applicationContext)

        val screenWidth = ScreenEz.width
        val screenHeight = ScreenEz.height

        val statusBarHeight = ScreenEz.statusBarHeight
        val navBarHeight = ScreenEz.softNavBarHeight

        Log.d("<>", "screen width: $screenWidth");
        Log.d("<>", "screen height: $screenHeight");
        Log.d("<>", "statusbar height: $statusBarHeight");
        Log.d("<>", "navbar height: $navBarHeight");

        setContent {
            Screenez_testTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {

        super.onConfigurationChanged(newConfig)

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Screenez_testTheme {
        Greeting("Android")
    }
}