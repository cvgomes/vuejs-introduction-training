var ConfigService = function(){
    
    var _api_url = "http://localhost:8080/tasks/";

    return {
        api_url: _api_url
    };
}();

export default ConfigService;