angular.module('app.services', []).factory('ListData', function($resource) {
  return $resource('/listdata/getList/:id', { id: '@id' }, {
    update: {
      method: 'PUT'
    }
  });
}).service('CatagoryData', function($resource) {
   return $resource('/catagory/getList/:id', { id: '@id' }, {
   update: {
       method: 'PUT'
   }
   });
}).service('ListDataItems', function($resource) {
   return $resource('/listdataitems/getItems/:id', { id: '@id' }, {
   update: {
       method: 'PUT'
   }
   });
}).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});