package xyz.godi.popularmovies.data;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

import xyz.godi.popularmovies.model.FavoriteMovie;
import xyz.godi.popularmovies.model.Movie;

@SuppressWarnings("unchecked")
public class MovieDAO_Impl implements MovieDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfMovie;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfMovie;

  public MovieDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMovie = new EntityInsertionAdapter<Movie>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Movie`(`id`,`poster_path`,`backdrop_path`,`original_title`,`release_date`,`vote_count`,`vote_average`,`overview`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Movie value) {
        stmt.bindLong(1, value.getId());
        if (value.getPoster_path() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPoster_path());
        }
        if (value.getBackdrop_path() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getBackdrop_path());
        }
        if (value.getOriginal_title() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getOriginal_title());
        }
        if (value.getRelease_date() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getRelease_date());
        }
        if (value.getVote_count() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getVote_count());
        }
        stmt.bindDouble(7, value.getVote_average());
        if (value.getOverview() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getOverview());
        }
      }
    };
    this.__deletionAdapterOfMovie = new EntityDeletionOrUpdateAdapter<Movie>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Movie` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Movie value) {
        stmt.bindLong(1, value.getId());
      }
    };
  }

  @Override
  public void insert(Movie movie) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfMovie.insert(movie);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(Movie movie) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfMovie.handle(movie);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public FavoriteMovie getMovieById(String id) {
    final String _sql = "SELECT id FROM Movie Where id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final FavoriteMovie _result;
      if(_cursor.moveToFirst()) {
        _result = new FavoriteMovie();
        _result.id = _cursor.getString(_cursorIndexOfId);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
