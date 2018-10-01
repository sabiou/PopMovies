package xyz.godi.popularmovies.data;

import android.arch.lifecycle.ComputableLiveData;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.InvalidationTracker.Observer;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import android.support.annotation.NonNull;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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
  public LiveData<List<Movie>> getAll() {
    final String _sql = "SELECT * FROM Movie";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new ComputableLiveData<List<Movie>>() {
      private Observer _observer;

      @Override
      protected List<Movie> compute() {
        if (_observer == null) {
          _observer = new Observer("Movie") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfPosterPath = _cursor.getColumnIndexOrThrow("poster_path");
          final int _cursorIndexOfBackdropPath = _cursor.getColumnIndexOrThrow("backdrop_path");
          final int _cursorIndexOfOriginalTitle = _cursor.getColumnIndexOrThrow("original_title");
          final int _cursorIndexOfReleaseDate = _cursor.getColumnIndexOrThrow("release_date");
          final int _cursorIndexOfVoteCount = _cursor.getColumnIndexOrThrow("vote_count");
          final int _cursorIndexOfVoteAverage = _cursor.getColumnIndexOrThrow("vote_average");
          final int _cursorIndexOfOverview = _cursor.getColumnIndexOrThrow("overview");
          final List<Movie> _result = new ArrayList<Movie>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Movie _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpPoster_path;
            _tmpPoster_path = _cursor.getString(_cursorIndexOfPosterPath);
            final String _tmpBackdrop_path;
            _tmpBackdrop_path = _cursor.getString(_cursorIndexOfBackdropPath);
            final String _tmpOriginal_title;
            _tmpOriginal_title = _cursor.getString(_cursorIndexOfOriginalTitle);
            final String _tmpRelease_date;
            _tmpRelease_date = _cursor.getString(_cursorIndexOfReleaseDate);
            final Integer _tmpVote_count;
            if (_cursor.isNull(_cursorIndexOfVoteCount)) {
              _tmpVote_count = null;
            } else {
              _tmpVote_count = _cursor.getInt(_cursorIndexOfVoteCount);
            }
            final double _tmpVote_average;
            _tmpVote_average = _cursor.getDouble(_cursorIndexOfVoteAverage);
            final String _tmpOverview;
            _tmpOverview = _cursor.getString(_cursorIndexOfOverview);
            _item = new Movie(_tmpId,_tmpPoster_path,_tmpBackdrop_path,_tmpOriginal_title,_tmpRelease_date,_tmpVote_count,_tmpVote_average,_tmpOverview);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    }.getLiveData();
  }

  @Override
  public Movie getMovieById(int id) {
    final String _sql = "SELECT * FROM Movie Where id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfPosterPath = _cursor.getColumnIndexOrThrow("poster_path");
      final int _cursorIndexOfBackdropPath = _cursor.getColumnIndexOrThrow("backdrop_path");
      final int _cursorIndexOfOriginalTitle = _cursor.getColumnIndexOrThrow("original_title");
      final int _cursorIndexOfReleaseDate = _cursor.getColumnIndexOrThrow("release_date");
      final int _cursorIndexOfVoteCount = _cursor.getColumnIndexOrThrow("vote_count");
      final int _cursorIndexOfVoteAverage = _cursor.getColumnIndexOrThrow("vote_average");
      final int _cursorIndexOfOverview = _cursor.getColumnIndexOrThrow("overview");
      final Movie _result;
      if(_cursor.moveToFirst()) {
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpPoster_path;
        _tmpPoster_path = _cursor.getString(_cursorIndexOfPosterPath);
        final String _tmpBackdrop_path;
        _tmpBackdrop_path = _cursor.getString(_cursorIndexOfBackdropPath);
        final String _tmpOriginal_title;
        _tmpOriginal_title = _cursor.getString(_cursorIndexOfOriginalTitle);
        final String _tmpRelease_date;
        _tmpRelease_date = _cursor.getString(_cursorIndexOfReleaseDate);
        final Integer _tmpVote_count;
        if (_cursor.isNull(_cursorIndexOfVoteCount)) {
          _tmpVote_count = null;
        } else {
          _tmpVote_count = _cursor.getInt(_cursorIndexOfVoteCount);
        }
        final double _tmpVote_average;
        _tmpVote_average = _cursor.getDouble(_cursorIndexOfVoteAverage);
        final String _tmpOverview;
        _tmpOverview = _cursor.getString(_cursorIndexOfOverview);
        _result = new Movie(_tmpId,_tmpPoster_path,_tmpBackdrop_path,_tmpOriginal_title,_tmpRelease_date,_tmpVote_count,_tmpVote_average,_tmpOverview);
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
