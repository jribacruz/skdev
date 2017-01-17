(function() {
	'use strict';

	angular.module("skdevMD").factory('fragmentSV', fragmentSV);

	fragmentSV.$inject = [ '$log', '$location', '$http' ];

	/**
	 * 
	 * @param $log
	 * @param $mdToast
	 * @returns
	 */
	function fragmentSV($log, $location, $http) {
		$log.debug('[fragmentSV] Inicializando... ');

		var origin = new URI($location.absUrl());

		var service = {
			findByName : findByName
		};

		function findByName(name) {
			var findByNameURL = origin.segment([ 'skdev', 'api', 'fragments', '_search' ]).href();
			$log.debug(format('[fragmentSV] load={}', findByNameURL));
			return $http.get(findByNameURL, {
				params : {
					name : name
				}
			});
		}

		return service;
	}

})();