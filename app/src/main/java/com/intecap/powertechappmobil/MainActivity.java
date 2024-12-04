package com.intecap.powertechappmobil;

import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NamedNavArgument;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    private boolean dobleTap = false;
    private Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);

        setContentView(R.layout.activity_main);

        //configurar el menu de navegacion
        BottomNavigationView navView = findViewById(R.id.bnvMenuNavegacionInferior);
        // Configuracion de la barra superior de navegacion, o definir los destinos de nivel superior
        AppBarConfiguration abcBarraConfiguracion = new AppBarConfiguration.Builder(R.id.pagina_inicio, R.id.pagina_favoritos, R.id.pagina_configuraciones).build();
        //Obtener el nacHostFragmet, el contenedor de fragmentos. Es el responsable de gestionar el navController
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fcvContenedorFragmentos);
        //Obtener el navController, componente que controla la navengacion, va maneja los cambios de los fragmnetos
        NavController nvcControladorNavegacion = navHostFragment.getNavController();
        //Configuraciones del grafico de navegacion desde el nav.xml  contiene la congiguracion de todos los destinos.
        nvcControladorNavegacion.setGraph(R.navigation.nav);
        //Sincronizamos nuestro BottonNaviationView con el NavController
        NavigationUI.setupWithNavController(navView,nvcControladorNavegacion);


        navView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            /**
             * Called when an item in the navigation menu is selected.
             *
             * @param item The selected item
             * @return true to display the item as the selected item and false if the item should not be
             * selected. Consider setting non-selectable items as disabled preemptively to make them
             * appear non-interactive.
             */
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()== R.id.itmInicio){
                    nvcControladorNavegacion.navigate(R.id.pagina_inicio);
                } else if (item.getItemId() == R.id.itmFavoritos) {
                    nvcControladorNavegacion.navigate(R.id.pagina_favoritos);

                } else if (item.getItemId()== R.id.itmConfiguraciones) {
                    nvcControladorNavegacion.navigate(R.id.pagina_configuraciones);

                }
                return true;
            }
        });

        navView.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                if(item.getItemId()== R.id.itmInicio){
                    Toast.makeText(MainActivity.this, "Item Home re-seleccionado", Toast.LENGTH_SHORT).show();
                } else if (item.getItemId() == R.id.itmFavoritos) {
                    Toast.makeText(MainActivity.this, "Item Favoritos re-seleccionado", Toast.LENGTH_SHORT).show();

                } else if (item.getItemId()== R.id.itmConfiguraciones) {
                    Toast.makeText(MainActivity.this, "Item Configuraciones re-seleccionado", Toast.LENGTH_SHORT).show();

                }
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if(dobleTap){
                    finish();
                }
                dobleTap= true;
                Toast.makeText(MainActivity.this, "presione nuevamente pra salir de la aplicacion", Toast.LENGTH_SHORT).show();
                handler.postDelayed(() -> dobleTap=false,2000);


            }
        });
    }


}