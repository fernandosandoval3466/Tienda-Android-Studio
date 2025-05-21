package com.example.tiendavirtual.Activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tiendavirtual.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task

class LoginActivity : AppCompatActivity() {
    private lateinit var Btn_Google: Button
    private lateinit var mGoogleSignInClient: GoogleSignInClient
    private lateinit var Btn_login: Button
    private val RC_SIGN_IN = 123
    private val TAG = "GoogleSignIn"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        Btn_login = findViewById(R.id.Btn_login)
        Btn_login.setOnClickListener {
            val intent = Intent(this, ProductActivity::class.java)
            startActivity(intent)
            finish()
        }


        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .requestProfile()
            .build()

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)

        Btn_Google = findViewById(R.id.Btn_Google)

        Btn_Google.setOnClickListener {
            signIn()
        }

}
    private fun signIn(){
        val signInIntent = mGoogleSignInClient.signInIntent
        startActivityForResult(signInIntent,RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
    }

    private fun handleSignInResult(completedtask: Task<GoogleSignInAccount>) {
        try {
            val account = completedtask.getResult(ApiException::class.java)
            Log.d(TAG, "signInResult:success: ${account.email}")
            Toast.makeText(this, "Bienvenido ${account.displayName}", Toast.LENGTH_SHORT).show()
            val productIntent = Intent(this, ProductActivity::class.java)
            productIntent.putExtra("email", account?.email)
            productIntent.putExtra("name", account?.displayName)
            startActivity(productIntent)
            finish()
        }catch (e: ApiException){
            Log.w(TAG, "signInResult:failed code=" + e.statusCode)
            Toast.makeText(this, "Error al iniciar sesión con Google: ${e.statusCode}", Toast.LENGTH_SHORT).show()
        }
    }

}