dramaStaticApp
  .service('DramaService',['baseUrl','$resource',function(baseUrl,$resource){
    return $resource(baseUrl.api+"/api/dramas/:id/:url",
        {id:'@id',url:'@url'});
  }]);
