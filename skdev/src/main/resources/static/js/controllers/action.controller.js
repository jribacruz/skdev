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
		
		function hide() {
			$mdDialog.hide();
		}

		function updateOnChange(targetId) {

		}
		
		function execute() {
			var values = {};
			angular.forEach(self.components, function(componentValue,id) {
				values[id] = componentValue.value;
			});
			console.log(values);
			$http.post('http://localhost:8080/skdev/api/execute/action/' + actionId, values);
		}

	}
})();