dramaStaticApp
  .factory('DramaService',function(baseUrl,$resource){
    return $resource(baseUrl.api+"api/dramas/:id",
        {id:'@id'},
        {query:{method:"GET",isArray:true}});
  });