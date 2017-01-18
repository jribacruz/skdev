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

		executeJSConsoleSV.subscribe(function(text) {
			self.logs.push('> ' + text);
		})

	}
})();