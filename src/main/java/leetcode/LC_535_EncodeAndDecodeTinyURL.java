package leetcode;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * https://leetcode.com/problems/encode-and-decode-tinyurl/
 *
 * 요구사항을 만족하는 기능
 * - longUrl 을 전달하면 임의의 tinyUrl 반환
 * - tinyUrl 을 전달하면 longUrl 반환
 *
 * related topic: Hash Table, String, Design, Hash Function
 * Time Complexity: O()
 * Space Complexity: O()
 */
public class LC_535_EncodeAndDecodeTinyURL {

	private final Map<String, UrlEncoder> cache = new HashMap<>();

	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		URI uri = URI.create(longUrl);

		UrlEncoder urlEncoder = new UrlEncoder(uri);
		cache.put(urlEncoder.getTinyUrl(), urlEncoder);

		return urlEncoder.getTinyUrl();
	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		if (cache.containsKey(shortUrl)) {
			return cache.get(shortUrl).getOriginalUrl();
		}
		return null;
	}

	private static class UrlEncoder {
		private final URI uri;
		private final int uriKey;

		public UrlEncoder(URI uri) {
			this.uri = uri;
			this.uriKey = uri.toString().hashCode();
		}

		/**
		 * @return decoded url (origin)
		 */
		public String getOriginalUrl() {
			return uri.toString();
		}

		/**
		 * @return encoded url
		 */
		public String getTinyUrl() {
			return String.format("%s://%s/%s", uri.getScheme(), uri.getHost(), uriKey);
		}
	}
}