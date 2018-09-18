package lvb.iso.com.listviewbasico;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

       mostrarListViewBasico();

    }

    private void init() {
        this.listView = findViewById(R.id.listView);
    }

    //mostrar lv con 1 txtview
    private void mostrarListViewBasico() {
        List<String> lista =
                new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.array_nr)));

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, lista);

        this.listView.setAdapter(arrayAdapter);

        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object object = parent.getAdapter().getItem(position);
                Toast.makeText(getBaseContext(), object.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    //devolver arrayAdapter con txtV color ROJO
    private ArrayAdapter<String> getAdapterListViewBasico(List<String> lista) {
        return new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, lista) {
            @Override
            public View getView(int position, View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                TextView txt = view.findViewById(android.R.id.text1);
                txt.setTextColor(Color.RED);
                return view;
            }

        };
    }

    //mostrar lv con 2 txtview
    private void mostrarListViewNombreCorreo() {
        String[] nombre = {"Juan", "David", "Lucia", "Raquel", "Sara","Juan", "David", "Lucia", "Raquel", "Sara",
                "Juan", "David", "Lucia", "Raquel", "Sara"};
        String[] correo = {"juan@gmail.com", "david@gmail.com",
                "lucia@gmail.com", "raquel@gmail.com", "sara@gmail.com","juan@gmail.com", "david@gmail.com",
                "lucia@gmail.com", "raquel@gmail.com", "sara@gmail.com","juan@gmail.com", "david@gmail.com",
                "lucia@gmail.com", "raquel@gmail.com", "sara@gmail.com"};


        ArrayList<Map<String, Object>> listaUsuarios = new ArrayList<>();

        int nombresLen = nombre.length;

        for (int i = 0; i < nombresLen; i++) {
            Map<String, Object> listItem = new HashMap<>();
            listItem.put("Nombre", nombre[i]);
            listItem.put("Correo", correo[i]);

            listaUsuarios.add(listItem);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listaUsuarios,
                android.R.layout.simple_list_item_2, new String[]{"Nombre", "Correo"},
                new int[]{android.R.id.text1, android.R.id.text2});

        this.listView.setAdapter(simpleAdapter);

        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object object = parent.getAdapter().getItem(position);
                Toast.makeText(getBaseContext(), object.toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    //devolver simpleAdapter con los colores txtV nombre, correo cambiados
    private SimpleAdapter getAdapterListViewNombreCorreo(ArrayList<Map<String, Object>> listaUsuarios){
        return new SimpleAdapter(this, listaUsuarios,
                android.R.layout.simple_list_item_2, new String[]{"Nombre", "Correo"},
                new int[]{android.R.id.text1, android.R.id.text2}){

            @Override
            public View getView(int position, View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                TextView txtNombre = view.findViewById(android.R.id.text1);
                txtNombre.setTextColor(Color.RED);

                TextView txtCorreo = view.findViewById(android.R.id.text2);
                txtCorreo.setTextColor(Color.BLUE);

                return view;
            }

        };
    }


    //TODO XML(ListView) android:choiceMode="singleChoice"
    private void mostrarListViewSingleChoiceChecked() {
        List<String> lista =
                new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.array_nr)));

        //TODO otra opcion android.R.layout.simple_list_item_single_choice
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_checked, lista);

        this.listView.setAdapter(arrayAdapter);

        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object object = parent.getAdapter().getItem(position);
                Toast.makeText(getBaseContext(), object.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    //TODO XML(ListView) android:choiceMode="multipleChoice"
    private void mostrarListViewMultipleChoiceChecked() {
        List<String> lista =
                new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.array_nr)));

        //TODO otra opcion android.R.layout.simple_list_item_multiple_choice
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_checked, lista);

        this.listView.setAdapter(arrayAdapter);

        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object object = parent.getAdapter().getItem(position);
                Toast.makeText(getBaseContext(), object.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }












}
