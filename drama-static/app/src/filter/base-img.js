dramaStaticApp
  .filter('baseImg',function (baseUrl) {
    return function(text){
      if(text&&!text.startsWith("/")){
        return baseUrl.img+"/"+text;
      }
      return baseUrl.img + text;
    }
  });