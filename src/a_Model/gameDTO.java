package a_Model;

public class gameDTO {
	String id;

	public gameDTO(mainDTO dto) {
		this.id = dto.getId();
	}

	public String getId() {
		return id;
	}

}
