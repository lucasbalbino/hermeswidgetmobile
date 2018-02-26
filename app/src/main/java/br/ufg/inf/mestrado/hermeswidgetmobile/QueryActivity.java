package br.ufg.inf.mestrado.hermeswidgetmobile;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
import com.hp.hpl.jena.rdf.model.*;
import java.util.Random;


public class QueryActivity  extends AppCompatActivity {
    double estimatedTime;
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
        this.estimatedTime = 0;
        if(MainActivity.id != 0) {
            Random rn = new Random();
            int randomCacheIndex = rn.nextInt(MainActivity.getCache().length);
            OntModel model[] = MainActivity.getCache();
            /*String queryString = "PREFIX ssn: <http://purl.oclc.org/NET/ssnx/ssn#> " +
                    "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
                    "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-sintax-ns#> " +
                    "PREFIX xsd: <http://wwww.w3.org/2001/XMLSchema#> " +
                    "PREFIX owl: <http://www.w3.org/2002/07/owl#> " +
                    "SELECT ?unidade ?valor " +
                    "WHERE{ " +
                    "?v ssn:hasOutputValue ?valor;" +
                    "ssn:hasOutputUnit ?unidade" +
                    "}";
            */

            String queryString = "PREFIX ssn: <http://purl.oclc.org/NET/ssnx/ssn#> "+
                    "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-sintax-ns#> " +
                    "SELECT ?s ?p ?o "+
                    "WHERE{" +
                    "?s ?p ssn:ObservationValue" +
                    "}";

            //Model union = ModelFactory.createDefaultModel();
            OntModel union = ModelFactory.createOntologyModel();
            for(int i = 0; i < model.length; i++)
                union.add(model[i]);


            TextView textCache = (TextView) findViewById(R.id.textView13);
            textCache.setText(String.valueOf(model.length));


            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText(queryModel(union, queryString));

            TextView textEstimatedTime = (TextView) findViewById(R.id.textView2);
            String time = this.estimatedTime + " s";
            textEstimatedTime.setText(time);


        }
        else{
            TextView textView = (TextView) findViewById(R.id.textView2);
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
        QueryExecution qe = null;
        ResultSet finalResults = null;
        long startTime = System.currentTimeMillis();
        qe = QueryExecutionFactory.create(query, model);
        ResultSet results = qe.execSelect();
        System.setOut(custom);
        ResultSetFormatter.out(System.out, results, query);
        qe.close();
        System.setOut(previous);
        Log.e("HW", "HERMES WIDGET FINALIZADO!!!!");
        estimatedTime = (System.currentTimeMillis() - startTime)/1000.0;
        return baos.toString();
    }

}
