package com.example.animeworldjetpackcompose.ui.features.login.method

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.animeworldjetpackcompose.R
import com.example.animeworldjetpackcompose.ui.component.BaseScreen
import com.example.animeworldjetpackcompose.ui.navigations.AppScreens
import com.example.animeworldjetpackcompose.ui.theme.ColorApp
import com.example.animeworldjetpackcompose.ui.theme.ColorBorderLight
import com.example.animeworldjetpackcompose.ui.theme.ColorTextPrimary

/**
 * @author mvn-toan.nguyen2 on 8/2/23
 **/

@Composable
internal fun MethodLoginScreen(nav: NavController) {
    val viewModel: MethodLoginVM = hiltViewModel()
    val color = MaterialTheme.colorScheme

    BaseScreen {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_welcome), contentDescription = null
            )
            ButtonSignInWith(
                text = stringResource(id = R.string.login_with_facebook),
                imageResource = painterResource(
                    id = R.drawable.ic_facebook
                ),
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .padding(top = 10.dp)
                    .fillMaxWidth()
                    .border(1.dp, color.tertiary, RoundedCornerShape(15.dp))
                    .padding(vertical = 15.dp),
            )
            ButtonSignInWith(
                text = stringResource(id = R.string.login_with_email),
                imageResource = painterResource(
                    id = R.drawable.ic_google
                ),
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 15.dp)
                    .padding(top = 10.dp)
                    .fillMaxWidth()
                    .border(1.dp, color.tertiary, RoundedCornerShape(15.dp))
                    .padding(vertical = 15.dp),
            )

            Row(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    Modifier
                        .border(1.dp, ColorBorderLight)
                        .height(1.dp)
                        .weight(1f)
                )
                Text(
                    text = stringResource(id = R.string.or),
                    modifier = Modifier.padding(horizontal = 10.dp)
                )
                Box(
                    Modifier
                        .border(1.dp, ColorBorderLight)
                        .height(1.dp)
                        .weight(1f)
                )
            }
            Text(
                text = stringResource(id = R.string.login_with_idpw),
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 10.dp)
                    .fillMaxWidth()
                    .clickable {
                    }
                    .shadow(20.dp, spotColor = ColorApp, shape = RoundedCornerShape(25.dp))
                    .background(color.primary, RoundedCornerShape(25.dp))
                    .padding(vertical = 10.dp, horizontal = 20.dp),
                fontSize = 16.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
            Row(modifier = Modifier.padding(top = 20.dp)) {
                Text(
                    text = stringResource(id = R.string.not_having_account),
                    fontSize = 16.sp,
                    color = ColorTextPrimary
                )
                Text(
                    text = stringResource(id = R.string.register),
                    color = ColorApp,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    modifier = Modifier.clickable {
                        nav.navigate(AppScreens.Register.route)
                    }
                )
            }
        }
    }
}

@Composable
fun ButtonSignInWith(
    modifier: Modifier = Modifier,
    text: String,
    imageResource: Painter? = null,
    textAlign: TextAlign = TextAlign.Center,
    fontSize: TextUnit = 16.sp,
    fontWeight: FontWeight = FontWeight.Bold
) {
    Row(
        modifier = modifier, horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (imageResource != null) {
            Image(
                painter = imageResource, contentDescription = null,
                modifier = Modifier.padding(end = 10.dp),
                alignment = Alignment.Center
            )
        }
        Text(
            text = text,
            fontSize = fontSize,
            textAlign = textAlign,
            fontWeight = fontWeight,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}
