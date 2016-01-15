
public class Event {

	private String title;
	private String ort;
	private double eintrittsPreis;
	
	public Event(String title, String ort, double eintrittsPreis) {
		this.title = title;
		this.ort = ort;
		this.eintrittsPreis = eintrittsPreis;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOrt() {
		return ort;
	}
	public void setOrt(String ort) {
		this.ort = ort;
	}
	public double getEintrittsPreis() {
		return eintrittsPreis;
	}
	public void setEintrittsPreis(double eintrittsPreis) {
		this.eintrittsPreis = eintrittsPreis;
	}
	@Override
	public String toString() {
		return "EventKalender [title=" + title + ", ort=" + ort + ", eintrittsPreis=" + eintrittsPreis + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(eintrittsPreis);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((ort == null) ? 0 : ort.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (Double.doubleToLongBits(eintrittsPreis) != Double.doubleToLongBits(other.eintrittsPreis))
			return false;
		if (ort == null) {
			if (other.ort != null)
				return false;
		} else if (!ort.equals(other.ort))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
}
