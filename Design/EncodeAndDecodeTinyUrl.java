package design;

import java.util.HashMap;
import java.util.Map;

public class EncodeAndDecodeTinyUrl {
	Map<String, String> encode = new HashMap<>();
    Map<String, String> decode = new HashMap<>();
    int count = 0;
    
    public String encode(String longUrl) {
        String code;
        if (!encode.containsKey(longUrl)) {
            code = "http://tinyurl.com/" + count;
            encode.put(longUrl, code);
            decode.put(code, longUrl);
            count++;
        } else {
            code = encode.get(longUrl);
        }
        
        return code;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return decode.getOrDefault(shortUrl, "");
    }
}
