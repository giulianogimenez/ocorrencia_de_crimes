package model;

public class Local {
	private String latitude;
	private String longitude;
	private LocalSpec localSpec;
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public LocalSpec getLocalSpec() {
		return localSpec;
	}
	public void setLocalSpec(LocalSpec localSpec) {
		this.localSpec = localSpec;
	}
}
