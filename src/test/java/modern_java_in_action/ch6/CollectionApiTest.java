package modern_java_in_action.ch6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CollectionApiTest {

	@DisplayName("computeIfAbsent 가 없을 때")
	@Test
	void mapTest1() {
		//given
		Map<String, List<String>> friendsToMovies = new HashMap<>();
		String friend = "Tom";

		//when
		List<String> movies = friendsToMovies.get(friend);
		if (movies == null) {
			movies = new ArrayList<>();
			friendsToMovies.put(friend, movies);
		}
		movies.add("Star Wars");

		//then
		Assertions.assertThat(friendsToMovies.get("Tom")).contains("Star Wars");

	}

	@DisplayName("computeIfAbsent 사용 시")
	@Test
	void mapTest2() {
		// given
		Map<String, List<String>> friendsToMovies = new HashMap<>();
		String friend = "Tom";

		//when
		friendsToMovies.computeIfAbsent(friend, k -> new ArrayList<>()).add("Star Wars");

		//then
		Assertions.assertThat(friendsToMovies.get("Tom")).contains("Star Wars");
	}

	@DisplayName("computeIfPresent 가 없을 때")
	@Test
	void mapTest3() {
		//given
		Map<String, List<String>> friendsToMovies = new HashMap<>();
		String friend = "Tom";
		friendsToMovies.put(friend, new ArrayList<>());

		//when
		List<String> movies = friendsToMovies.get(friend);
		if (movies != null) {
			movies.add("Star Wars");
		}

		//then
		Assertions.assertThat(friendsToMovies.get("Tom")).contains("Star Wars");
	}

	@DisplayName("computeIfPresent 사용 시")
	@Test
	void mapTest4() {
		//given
		Map<String, List<String>> friendsToMovies = new HashMap<>();
		String friend = "Tom";
		friendsToMovies.put(friend, new ArrayList<>());

		//when
		friendsToMovies.computeIfPresent(friend, (k, v) -> {
			v.add("Star Wars");
			return v;
		});

		//then
		Assertions.assertThat(friendsToMovies.get("Tom")).contains("Star Wars");
	}

	@DisplayName("computeIfPresent 사용 시 - null")
	@Test
	void mapTest5() {
		//given
		Map<String, List<String>> friendsToMovies = new HashMap<>();
		String friend = "Tom";

		//when
		friendsToMovies.computeIfPresent(friend, (k, v) -> {
			v.add("Star Wars");
			return v;
		});

		//then
		Assertions.assertThat(friendsToMovies.get("Tom")).isNull();
	}

	@DisplayName("compute 가 없을 때")
	@Test
	void mapTest6() {
		//given
		Map<String, List<String>> friendsToMovies = new HashMap<>();
		String friend = "Tom";
		friendsToMovies.put(friend, new ArrayList<>());

		//when
		List<String> movies = friendsToMovies.get(friend);
		movies.add("Star Wars");

		//then
		Assertions.assertThat(friendsToMovies.get("Tom")).contains("Star Wars");
	}

	@DisplayName("compute 사용시")
	@Test
	void mapTest7() {
		//given
		Map<String, List<String>> friendsToMovies = new HashMap<>();
		String friend = "Tom";
		friendsToMovies.put(friend, new ArrayList<>());

		//when
		friendsToMovies.compute(friend, (k, v) -> {
			v.add("Star Wars");
			return v;
		});

		//then
		Assertions.assertThat(friendsToMovies.get("Tom")).contains("Star Wars");
	}

	@DisplayName("Map - merge")
	@Test
	void mapTest8() {
		Map<String, List<Integer>> coffeeMap = new HashMap<>();
		coffeeMap.put("메가커피", new ArrayList<>());
		coffeeMap.get("메가커피").add(2000);
		coffeeMap.put("스타벅스", new ArrayList<>());
		coffeeMap.get("스타벅스").add(3500);
		coffeeMap.put("빽다방", new ArrayList<>());
		coffeeMap.get("빽다방").add(2100);

		Map<String, List<Integer>> coffeeMap2 = new HashMap<>();
		coffeeMap2.put("메가커피", new ArrayList<>());
		coffeeMap2.get("메가커피").add(3000);
		coffeeMap2.put("스타벅스", new ArrayList<>());
		coffeeMap2.get("스타벅스").add(4500);

		coffeeMap.forEach((k, v) ->
			coffeeMap2.merge(k, v, (price1, price2) -> {
				System.out.println("price1 = " + price1);
				System.out.println("price2 = " + price2);
				price1.addAll(price2);
				return price1;
			}));

		System.out.println("coffeeMap2 = " + coffeeMap2);
	}
}
