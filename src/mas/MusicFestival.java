package mas;

public class MusicFestival{

	private String name;
	private String sceneName;

	public MusicFestival() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		validateString(name);
		this.name = name;
	}

	public String getSceneName() {
		return sceneName;
	}

	public void setSceneName(String sceneName) {
		validateString(sceneName);
		this.sceneName = sceneName;
	}

	private void validateString(String str) {
		if (str == null) {
			throw new IllegalArgumentException("Name cannot be null!");
		}
		if (str.isEmpty()) {
			throw new IllegalArgumentException("Name must have 1 character or more");
		}
	}

	@Override
	public String toString() {
		return "MusicFestival [name=" + name + ", sceneName=" + sceneName + "]";
	}

}
