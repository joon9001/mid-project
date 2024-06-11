package pack;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URLEncoder;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class KakaoAPI {

    private static String API_KEY = "3ea7c541daf7cd8372ccbd7b6e8869ce";
    private static String search_book_URL = "https://dapi.kakao.com/v3/search/book";

    public ArrayList<Book> findBookListByKeyword(String keyword) throws IOException {
        String url = search_book_URL + "?query=" + URLEncoder.encode(keyword, "UTF-8");
        JSONObject BookInformationJson = requestApi(url);
        JSONArray documents = BookInformationJson.getJSONArray("documents");

        ArrayList<Book> booklist = new ArrayList<>();
        if (documents.length() != 0) {
            for (int i = 0; i < documents.length(); i++) {
                JSONObject bookObject = documents.getJSONObject(i);
                Book book = new Book((String) bookObject.get("title"), (Integer) bookObject.get("price"), (String) bookObject.get("publisher"), (Integer) bookObject.get("sale_price"), (JSONArray) bookObject.get("authors"), (String) bookObject.get("isbn"));
                booklist.add(book);
                System.out.println(book);
            }
        } else {
            System.out.println("찾으려는 도서가 없습니다.");
        }
        return booklist;
    }

    private JSONObject requestApi(String apiUrl) {
        String BookInformationJson = "";
        try {
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet getRequest = new HttpGet(apiUrl);
            getRequest.setHeader("Authorization","KakaoAK "+API_KEY);
            HttpResponse getResponse = httpClient.execute(getRequest);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getResponse.getEntity().getContent(),"UTF-8"));
            BookInformationJson = bufferedReader.readLine();
            httpClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new JSONObject(BookInformationJson);


    }
}
