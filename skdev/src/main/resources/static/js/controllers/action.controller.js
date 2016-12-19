(function() {
	'use strict';

	angular.module('skdevMD').controller('ActionCT', ActionCT);

	ActionCT.$inject = [ '$scope', '$log', '$http', '$mdDialog', 'actionData', 'actionId', '$mdToast','$location' ];

	/**
	 * 
	 * @param $scope
	 * @param $log
	 * @param $http
	 * @param $mdDialog
	 * @param actionDialog
	 * @param actionId
	 * @param $mdToast
	 * @returns
	 */
	function ActionCT($scope, $log, $http, $mdDialog, actionData, actionId, $mdToast, $location) {
		$log.debug('[ActionCT] Inicializando...');
		var self = this;

		self.hide = hide;

		self.execute = execute;

		self.values = {};

		self.endpoints = {};

		var context = format('http://{}:{}/skdev', $location.host(), $location.port());

		//loadEndpoints();
		
		/*
		function loadEndpoints() {
			angular.forEach(actionData.endpoints, function(endpointV, endpointK) {
				$http.get(format('{}{}', context, endpointV))
					.success(function(data) {
						self.endpoints[endpointK] = data;
					});
			});
		}*/

		function hide() {
			$mdDialog.hide();
		}

		function execute() {
			console.log(self.values);
			
			$http.post('http://localhost:8080/skdev/api/actions/' + actionId, self.values).success(function(data) {
				$mdDialog.hide();
				$mdToast.show($mdToast.simple().textContent('Ação executada com sucesso!').position("top right").hideDelay(3000));
			});
			
			hide();
			/*
			if(self.config.actionSuccess.showOnSuccessExecute) {
				$http.get(format('{}/api/actions/{}/success', context, actionId));
			}*/
		}

	}
})();