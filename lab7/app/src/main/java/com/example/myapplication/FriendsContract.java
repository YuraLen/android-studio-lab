package com.example.myapplication;

import android.content.ContentUris;
import android.net.Uri;

public class FriendsContract {
    // Назва таблиці в БД
    static final String TABLE_NAME = "friends";

    // Authority - це унікальне ім'я вашого провайдера (має співпадати з тим, що в Маніфесті)
    static final String CONTENT_AUTHORITY = "com.example.friendsprovider";

    // Базовий URI (адреса), за якою можна знайти провайдер
    static final Uri CONTENT_AUTHORITY_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    // MIME-типи даних (для системи Android, щоб вона знала, що ми повертаємо)
    static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd." + CONTENT_AUTHORITY + "." + TABLE_NAME;
    static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd." + CONTENT_AUTHORITY + "." + TABLE_NAME;

    // Опис колонок таблиці
    public static class Columns {
        public static final String _ID = "_id";
        public static final String NAME = "Name";
        public static final String EMAIL = "Email";
        public static final String PHONE = "Phone";

        private Columns() {
        }
    }

    // Повний URI до таблиці friends
    static final Uri CONTENT_URI = Uri.withAppendedPath(CONTENT_AUTHORITY_URI, TABLE_NAME);

    // Метод створює повний URI для конкретного запису (наприклад, friend/5)
    static Uri buildFriendUri(long taskId) {
        return ContentUris.withAppendedId(CONTENT_URI, taskId);
    }

    // Метод витягує ID з URI
    static long getFriendId(Uri uri) {
        return ContentUris.parseId(uri);
    }
}