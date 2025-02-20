package com.guercifzone.tafsirahlam.JsonParser;

import android.content.Context;
import android.content.res.Resources;

import com.guercifzone.tafsirahlam.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Tafsir_7 {
    public static List<Tafsir_7.SectionGroupOne> readJsonFile(Context context) {
        List<Tafsir_7.SectionGroupOne> sectionsList = new ArrayList<>();
        try {
            Resources resources = context.getResources();
            InputStream inputStream = resources.openRawResource(R.raw.tafsir_7);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            String jsonString = new String(buffer, "UTF-8");
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray sections = jsonObject.getJSONArray("sections");
            for (int i = 0; i < sections.length(); i++) {
                JSONObject section = sections.getJSONObject(i);
                String sectionTitle = section.getString("title");
                Object content = section.get("content");

                if (content instanceof String) {
                    sectionsList.add(new Tafsir_7.SectionGroupOne(sectionTitle, (String) content));
                } else if (content instanceof  JSONArray) {
                    StringBuilder contentBuilder = new StringBuilder();
                    JSONArray contentArray = (JSONArray) content;
                    for (int j = 0; j < contentArray.length(); j++) {
                        contentBuilder.append(contentArray.getString(j)).append("\n");
                    }
                    sectionsList.add(new Tafsir_7.SectionGroupOne(sectionTitle, contentBuilder.toString()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sectionsList;
    }
    public static class SectionGroupOne {
        private String title;
        private String content;

        public SectionGroupOne(String title, String content) {
            this.title = title;
            this.content = content;
        }

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }
    }
}
