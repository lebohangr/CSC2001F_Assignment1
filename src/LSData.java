public class LSData {
    private String StageDayTime;
    private String listOfAreas;

    public String getListOfAreas() {
        return listOfAreas;
    }


    @Override
    public String toString() {
        return "LSData{" +
                "StageDayTime='" + StageDayTime + '\'' +
                ", listOfAreas='" + listOfAreas + '\'' +
                '}';
    }

    public LSData(String stageDayTime, String listOfAreas) {
        this.StageDayTime = stageDayTime;
        this.listOfAreas = listOfAreas;

    }

    public LSData(){

    }
}
