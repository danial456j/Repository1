package logic;

import javafx.scene.image.ImageView;

public class Item {
	private String id;
	private String amount;
	private ImageView image;
	private String imageName;
	
	public Item(String id, String amount, String imageName) {
		super();
		this.id = id;
		this.amount = amount;
		this.imageName = imageName;
		image = new ImageView(imageName);
		image.setFitHeight(70);
		image.setFitWidth(70);
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getId() {
		return id;
	}
	public void setId(String iD) {
		id = iD;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public ImageView getImage() {
		return image;
	}
	public void setImage(ImageView image) {
		this.image = image;
	}

}
