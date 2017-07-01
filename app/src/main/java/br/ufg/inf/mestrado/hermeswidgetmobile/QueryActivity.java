package br.ufg.inf.mestrado.hermeswidgetmobile;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.query.ResultSet;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import com.hp.hpl.jena.ontology.OntModel;

import java.util.Random;


public class QueryActivity  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_query);
            this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onStart() {
        super.onStart();
        if(MainActivity.getCache() != null) {
            Random rn = new Random();
            int randomCacheIndex = rn.nextInt(MainActivity.getCache().length);
            OntModel model = MainActivity.getCache(randomCacheIndex);
            String queryString = "PREFIX ssn: <http://purl.oclc.org/NET/ssnx/ssn#> " +
                    "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
                    "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-sintax-ns#> " +
                    "PREFIX xsd: <http://wwww.w3.org/2001/XMLSchema#> " +
                    "PREFIX owl: <http://www.w3.org/2002/07/owl#> " +
                    "SELECT ?unidade ?valor " +
                    "WHERE{ " +
                    "?v ssn:hasOutputValue ?valor;" +
                    "ssn:hasOutputUnit ?unidade" +
                    "}";


            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText(queryModel(model, queryString));

            TextView textArg2 = (TextView) findViewById(R.id.textView11);
            textArg2.setText(String.valueOf(randomCacheIndex));
        }
        else{
            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText("Cache vazio!\nRode um Hermes Widget primeiro!!");

            TextView textArg2 = (TextView) findViewById(R.id.textView11);
            textArg2.setText("NENHUM!!");
        }
    }


    public String queryModel(OntModel model, String queryString){
        ByteArrayOutputStream baos;
        PrintStream previous;
        previous = System.out;
        baos = new ByteArrayOutputStream();
        // OutputStream outputStreamCombiner = new OutputStreamCombiner(Arrays.asList(previous, baos));
        PrintStream custom = new PrintStream(baos);

        Query query = QueryFactory.create(queryString);
        QueryExecution qe = QueryExecutionFactory.create(query, model);
        ResultSet results =  qe.execSelect();

        System.setOut(custom);
        ResultSetFormatter.out(System.out, results, query);
        qe.close();
        System.setOut(previous);

        return baos.toString();
    }

}
