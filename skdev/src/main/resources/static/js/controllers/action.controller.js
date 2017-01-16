(function() {
	'use strict';

	angular.module('skdevMD').controller('ActionCT', ActionCT);

	ActionCT.$inject = [ '$scope', '$log', '$mdDialog', 'eAction', '$http', 'projectSV', '$location' ];

	/**
	 * 
	 * @param $scope
	 * @param $log
	 * @returns
	 */
	function ActionCT($scope, $log, $mdDialog, eAction, $http, projectSV, $location) {
		$log.debug('[ActionCT] Inicializando...');
		var self = this;

		var origin = new URI($location.absUrl());

		var editors = {};

		self.hide = hide;

		self.load = load;

		self.options = {};

		self.values = {};

		init();

		function init() {

		}

		function hide() {
			$mdDialog.hide();
		}

		function load(id, endpoint) {
			$log.debug('[ActionCT] ProjectName: ' + projectSV.getSelectedProject().name);
			var loadURL = origin.segment(["skdev", "api", "projects", projectSV.getSelectedProject().name, endpoint ]).href();
			$log.debug('[ActionCT] load: ' + loadURL);
			$http.get(loadURL).then(function(res) {
				self.options[id] = res.data;
			});
		}
	}
})();
