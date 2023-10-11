package Resources;

public enum APIResources {

    addPlace("/maps/api/place/add/json"),
    deletePlace("/maps/api/place/delete/json"),
    getPlace("/maps/api/place/get/json");

    String resource;
    APIResources(String resource) {
        this.resource = resource;
    }
    public String getResource() {
        return resource;
    }
}
