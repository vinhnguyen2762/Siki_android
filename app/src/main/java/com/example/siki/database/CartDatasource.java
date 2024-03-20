package com.example.siki.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.siki.model.Cart;
import com.example.siki.model.Product;
import com.example.siki.model.User;

import java.util.ArrayList;
import java.util.List;

public class CartDatasource {
    private SQLiteDatabase db;
    private SikiDatabaseHelper dbHelper;

    private ProductDatabase productDatabase;

    private UserDataSource userDataSource ;

    public CartDatasource(Context context) {
        dbHelper = new SikiDatabaseHelper(context);
    }

    public void open() {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public List<Cart> findByUser(int userId) {
        String sql = "Select * from Cart c where c.user_id = ?";
        List<Cart> listCart = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, new String[]{String.valueOf(userId)});
        if (cursor.moveToFirst()) {
            do {
                Cart cart = new Cart();
                cart.setId(cursor.getLong(0));
                cart.setQuantity(cursor.getInt(3));
                Long productId = cursor.getLong(2);
                Product product = productDatabase.findById(productId);
                cart.setProduct(product);
                User user = userDataSource.getUserById(userId);
                cart.setUser(user);
                listCart.add(cart);
            } while (cursor.moveToNext());
        }
        return listCart;
    }

    public long addToCart (Long productId, int userId) {
        long id = -1;
        try {
            ContentValues values = new ContentValues();
            values.put("user_id", userId);
            values.put("product_id", productId);
            values.put("quantity", 1);
            values.put("is_selected", false);
            id = db.insert("Cart", null, values);
        } catch (Exception e) {
            // Handle any exceptions
            e.printStackTrace();
        }
        return id;
    }

    public int updateCartQuantity (Long cartId, int quantity) {
        int rowsAffected = -1;
        try {
            ContentValues values = new ContentValues();
            values.put("quantity", quantity);
            rowsAffected = db.update("Cart", values, "id=?", new String[]{String.valueOf(cartId)});
        } catch (Exception e) {
            // Handle any exceptions
            e.printStackTrace();
        }
        return rowsAffected;
    }


    public int updateSelectedCart(Long cartId, boolean isSelected) {
        int rowsAffected = -1;
        try {
            ContentValues values = new ContentValues();
            values.put("is_selected", isSelected);
            rowsAffected = db.update("Cart", values, "id=?", new String[]{String.valueOf(cartId)});
        } catch (Exception e) {
            // Handle any exceptions
            e.printStackTrace();
        }
        return rowsAffected;
    }


    public int remove (Long cartId) {
        int rowsAffected = -1;
        try {
            rowsAffected = db.delete("Cart", "id=?", new String[]{String.valueOf(cartId)});
        } catch (Exception e) {
            // Handle any exceptions
            e.printStackTrace();
        }
        return rowsAffected;
    }


    // Todo: Update selection by shop id
    //
}
