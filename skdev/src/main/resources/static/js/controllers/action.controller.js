(function() {
	'use strict';

	angular.module('skdevMD').controller('ActionCT', ActionCT);

	ActionCT.$inject = [ '$scope', '$log', '$http', '$mdDialog', 'actionDialog', 'actionId' ];

	/**
	 * 
	 * @param $scope
	 * @param $log
	 * @param $http
	 * @returns
	 */
	function ActionCT($scope, $log, $http, $mdDialog, actionDialog, actionId) {
		$log.debug('[ActionCT] Inicializando...');
		var self = this;

		self.hide = hide;

		self.components = actionDialog.componentMap;
		
		self.updateOnChange = updateOnChange;
		
		self.execute = execute;
		
		self.values = {};
		
		function hide() {
			$mdDialog.hide();
		}

		function updateOnChange(targetId, optionEndpoint) {

		}
		
		function execute() {
			console.log(self.values);
			$http.post('http://localhost:8080/skdev/api/execute/action/' + actionId, self.values);
		}

	}
})();