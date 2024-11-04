import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.telefono.R
import com.example.telefono.api.ApiClient
import com.example.telefono.modelo.Persona
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Asegúrate de que el nombre del layout sea correcto

        val apiService = ApiClient.getClient().create(ApiService::class.java)
        val call: Call<List<Persona>> = apiService.getPersonas()


        call.enqueue(object : Callback<List<Persona>?> {
            override fun onResponse(
                call: Call<List<Persona>?>,
                response: Response<List<Persona>?>,
            ) {
                if (response.isSuccessful && response.body() != null) {
                    val personas = response.body()!!
                    for (persona in personas) {
                        Log.d("API", "Nombre: ${persona.nombre}, Email: ${persona.email}")
                    }
                } else {
                    Log.e("API", "Error en la respuesta: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<Persona>?>, t: Throwable) {
                Log.e("API", "Error: ${t.message}")
            }
        })
    }
}
