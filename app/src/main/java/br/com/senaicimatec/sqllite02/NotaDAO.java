package br.com.senaicimatec.sqllite02;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class NotaDAO {
    private Conexao conexao;
    private SQLiteDatabase db;
    private SQLiteDatabase RO;
    private String TableName = "nota";

    public NotaDAO(Context context){
        conexao = new Conexao(context);
        db = conexao.getWritableDatabase();
        RO = conexao.getReadableDatabase();
    }

    public long Inserir (Nota nota){
        ContentValues values = new ContentValues();
        values.put("Descricao", nota.getDescricao());
        return db.insert(TableName, null, values);
    }

    public ArrayList<Nota> get() {
        try {
            Cursor cursorNota = RO.rawQuery("select * from " + TableName, null);

            ArrayList<Nota> notaList = new ArrayList<>();

            if (cursorNota.moveToFirst()) {
                do {
                    Nota novaNota = new Nota();

                    int idIndex = cursorNota.getColumnIndex("Id");
                    int descricaoIndex = cursorNota.getColumnIndex("Descricao");

                    String indexValue = cursorNota.getString(idIndex);

                    int id = Integer.parseInt(indexValue);

                    novaNota.setId(id);
                    novaNota.setDescricao(cursorNota.getString(descricaoIndex));

                    notaList.add(novaNota);
                } while(cursorNota.moveToNext());
            }

            cursorNota.close();

            return notaList;
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
            return new ArrayList<Nota>();
        }

    }
}
