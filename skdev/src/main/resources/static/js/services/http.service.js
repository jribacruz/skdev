(function() {
	'use strict';

	angular.module("skdevMD").factory('HttpSV', HttpSV);

	HttpSV.$inject = [ '$log', '$http', '$location' ];

	/**
	 * 
	 * @param $log
	 * @param $http
	 * @param $location
	 * @returns
	 */
	function HttpSV($log, $http, $location) {
		$log.debug('[HttpSV] Inicializando... ');

		var context = 'http://' + $location.host() + ':' + $location.port() + '/skdev/api';

		var loaders = {};
		
		var service = {
			get : get,
			registerLoaders: registerLoaders
		}

		return service;
		
		/**
		 * Função Http GET
		 */
		function get(path, options) {
			//console.log(context+path);
			if(options.loader) {
				loaders[options.loader] = true;
			}
			return $http.get(context+path)
				.then(httpComplete)
				.catch(httpFailure);
			
			function httpComplete(response) {
				loaders[options.loader] = false;
				return response.data;
			}
			
			function httpFailure(error) {
				loaders[options.loader] = false;
				$log.debug('Request failed');
			}
		}
		
		function registerLoaders(httpLoaders) {
			angular.forEach(httpLoaders, function(httpLoader) {
				var defaultState = httpLoader.split(':').length > 1 ?  httpLoader.split(':')[1]==='true': true;
				//console.log(httpLoader.split(':'))
				//console.log(httpLoader.split(':')[1]==='true')
				//console.log(httpLoader.split(':').length)
				//console.log(defaultState);
				loaders[httpLoader.split(':')[0]] = defaultState;
			});
			return loaders;
		}

	}

})();