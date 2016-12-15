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

		self.options = {};

		self.config = {};

		var context = format('http://{}:{}/skdev', $location.host(), $location.port());

		
		loadConfig();

		function loadConfig() {
			$log.debug(format("[ActionCT] Carregando configurações da action={}", actionId));
			$http.get(format('{}{}', context, actionData.config)).success(function(data) {
				self.config = data;
				loadOptions();
			});
		}
		
		function loadOptions() {
			angular.forEach(self.config, function(itemConfig, id) {
				if(itemConfig['optionsEndpoint']) {
					$http.get(format('{}{}', context, itemConfig['optionsEndpoint']))
						.success(function(data) {
							self.options[id] = data;
						});
				}
			});
		}

		function hide() {
			$mdDialog.hide();
		}

		function execute() {
			console.log(self.values);
			$http.post('http://localhost:8080/skdev/api/execute/action/' + actionId, self.values).success(function(data) {
				$mdDialog.hide();
				$mdToast.show($mdToast.simple().textContent('Ação executada com sucesso!').position("top right").hideDelay(3000));
			});
		}

	}
})();