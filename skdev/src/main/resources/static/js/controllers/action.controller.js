(function() {
	'use strict';

	angular.module('skdevMD').controller('ActionCT', ActionCT);

	ActionCT.$inject = [ '$scope', '$log', '$http', '$mdDialog', 'actionDialog', 'actionId', '$mdToast' ];

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
	function ActionCT($scope, $log, $http, $mdDialog, actionDialog, actionId, $mdToast) {
		$log.debug('[ActionCT] Inicializando...');
		var self = this;

		self.hide = hide;

		self.components = actionDialog.componentMap;

		self.execute = execute;

		self.values = {};

		self.options = {};

		initOptions();

		function initOptions() {
			$log.debug('[ActionCT] Inicializado options...');
			angular.forEach(self.components, function(component, id) {
				if (!angular.isUndefined(component.options)) {
					self.options[id] = component.options;
				} else if (!angular.isUndefined(component.optionsEndpoint)) {
					$http.get(component.optionsEndpoint).success(function(data) {
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
			$http.post('http://localhost:8080/skdev/api/execute/action/' + actionId, self.values).success(
					function(data) {
						$mdDialog.hide();
						$mdToast.show($mdToast.simple().textContent(
								'Ação executada com sucesso!').position("top right").hideDelay(3000));
					});
		}

	}
})();