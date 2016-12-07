(function() {
	'use strict';

	angular.module('skdevMD').controller('ActionListCT', ActionListCT);

	ActionListCT.$inject = [ '$scope', '$log', '$http', '$mdDialog' ];

	/**
	 * 
	 * @param $scope
	 * @param $log
	 * @param $http
	 * @returns
	 */
	function ActionListCT($scope, $log, $http) {
		$log.debug('[ActionListCT] Inicializando...');
		var self = this;

		self.actions = [];
			
		$http.get('http://localhost:8080/skdev/api/actions')
			.then(function(response) {
				self.actions = response.data
			});

	}
})();