'use strict';

// Declare app level module which depends on views, and core components
var dramaStaticApp = angular.module('dramaStaticApp', [
  'ngRoute',
  'ngResource'
])
    .constant("baseUrl",{
      "api":"http://localhost:8088/"
    })
;
