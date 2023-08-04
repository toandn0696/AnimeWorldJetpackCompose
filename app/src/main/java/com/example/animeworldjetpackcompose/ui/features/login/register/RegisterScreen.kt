package com.example.animeworldjetpackcompose.ui.features.login.register

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.animeworldjetpackcompose.R
import com.example.animeworldjetpackcompose.ui.component.BaseScreen
import com.example.animeworldjetpackcompose.ui.theme.ColorApp

/**
 * @author mvn-toan.nguyen2 on 8/2/23
 **/

@Composable
fun RegisterScreen() {
    val color = MaterialTheme.colorScheme


    val focusManager = LocalFocusManager.current

    BaseScreen {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Create Your Account",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = color.secondary
            )
            TextFieldEmail()
            TextFieldPassword(focusManager = focusManager)
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
        }
    }
}

@Composable
fun TextFieldEmail() {
    var email by rememberSaveable {
        mutableStateOf("")
    }
    OutlinedTextField(
        modifier = Modifier
            .padding(vertical = 10.dp, horizontal = 20.dp)
            .fillMaxWidth(),
        value = email,
        onValueChange = {
            email = it
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_mail),
                contentDescription = null
            )
        },
        placeholder = {
            Text(text = stringResource(id = R.string.placeholder_email))
        }, singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        )
    )
}

@Composable
fun TextFieldPassword(focusManager: FocusManager) {
    var password by rememberSaveable {
        mutableStateOf("")
    }
    var isShowPassword by rememberSaveable {
        mutableStateOf(false)
    }
    OutlinedTextField(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth(),
        value = password,
        onValueChange = {
            password = it
        },
        trailingIcon = {
            IconButton(onClick = { isShowPassword = !isShowPassword }) {
                Icon(
                    painter = painterResource(id = if (isShowPassword) R.drawable.ic_hidden_pw else R.drawable.ic_show_pw),
                    contentDescription = null
                )
            }
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_password),
                contentDescription = null
            )
        },
        visualTransformation = if (isShowPassword) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        placeholder = {
            Text(text = stringResource(id = R.string.placeholder_password))
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = {
            focusManager.clearFocus()
        })
    )
}