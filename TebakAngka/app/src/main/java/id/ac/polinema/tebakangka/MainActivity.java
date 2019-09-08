package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

	//  TODO: deklarasikan variabel di sini
	int angkaRandom = 0;
	Button btn ;
	Button rst;
	EditText editAngka;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// TODO: bind layout di sini
		btn = (Button) findViewById(R.id.guess_button);
		rst = (Button) findViewById(R.id.reset_button);
		editAngka = (EditText) findViewById(R.id.number_input);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (!editAngka.equals("")) {
					handleGuess(view);
				}
			}
		});
	}

	// TODO: generate angka random di sini
	private int random(int angkaMin, int angkaMax){
		Random rand = new Random();
		int randomNum = rand.nextInt(angkaMax - angkaMin) + angkaMin;
		return randomNum;
	}

	private void handleGuess(View view) {
		// TODO: Tambahkan logika untuk melakukan pengecekan angka
		int angkaTebakan = Integer.parseInt(editAngka.getText().toString());
		if (angkaTebakan == angkaRandom){
			Toast.makeText(this, "Tebakan Anda Benar", Toast.LENGTH_SHORT).show();
		} else if (angkaTebakan > angkaRandom) {
			Toast.makeText(this, "Tebakan Anda Terlalu Besar !", Toast.LENGTH_SHORT).show();
		} else if (angkaTebakan < angkaRandom){
			Toast.makeText(this, "Tebakan Anda Terlalu Kecil !", Toast.LENGTH_SHORT).show();
		}
		angkaRandom = random(1, 100);
	}

	public void handleReset(View view) {
		// TODO: Reset tampilan
		rst.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view) {
				editAngka.setText("");
			}
		});
	}

	@Override
	protected void onStop() {
		super.onStop();
		Toast.makeText(this, "Application Closed", Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onStart() {
		super.onStart();
		Toast.makeText(this, "Application Start", Toast.LENGTH_SHORT).show();
	}
}
