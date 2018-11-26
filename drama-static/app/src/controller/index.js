'use strict';

/**
 * @ngdoc function
 * @name dramaStaticApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the dramaStaticApp
 */
dramaStaticApp
  .controller('IndexCtrl', function (DramaService) {
    var list = DramaService.query();
    DramaService.get({id:1},function(resp){console.info(resp)});
    console.info(list);
    console.info("test index");
  });
