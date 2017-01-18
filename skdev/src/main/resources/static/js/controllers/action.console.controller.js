(function() {
	'use strict';

	angular.module('skdevMD').controller('ActionConsoleCT', ActionConsoleCT);

	ActionConsoleCT.$inject = [ '$scope', '$log', '$http', '$mdDialog', 'actionSV', 'executeJSConsoleSV' ];

	/**
	 * 
	 * @param $scope
	 * @param $log
	 * @param $http
	 * @param $mdDialog
	 * @param HttpSV
	 * @returns
	 */
	function ActionConsoleCT($scope, $log, $http, $mdDialog, actionSV, executeJSConsoleSV) {
		$log.debug('[ActionConsoleCT] Inicializando...');
		var self = this;

		self.logs = [];

		self.hide = hide;

		self.visibleDetail = {};
		
		self.toggleDetail = toggleDetail;

		executeJSConsoleSV.subscribe(function(log) {
			self.logs.push(log);
		})

		function hide() {
			$mdDialog.hide();
		}
		
		function toggleDetail(index) {
			self.visibleDetail[index] = !self.visibleDetail[index];
		}

	}
})();