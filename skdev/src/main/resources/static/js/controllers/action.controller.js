(function() {
	'use strict';

	angular.module('skdevMD').controller('ActionCT', ActionCT);

	ActionCT.$inject = [ '$scope', '$log', '$http', '$mdDialog', 'actionDialog' ];

	/**
	 * 
	 * @param $scope
	 * @param $log
	 * @param $http
	 * @returns
	 */
	function ActionCT($scope, $log, $http, $mdDialog, actionDialog) {
		$log.debug('[ActionCT] Inicializando...');
		var self = this;

		self.hide = hide;

		self.components = actionDialog.components;
		
		self.updateOnChange = updateOnChange;
		
		self.execute = execute;
		
		function hide() {
			$mdDialog.hide();
		}

		function updateOnChange(targetId) {

		}
		
		function execute() {
			
		}

	}
})();