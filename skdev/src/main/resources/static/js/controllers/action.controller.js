(function() {
	'use strict';

	angular.module('skdevMD').controller('ActionCT', ActionCT);

	ActionCT.$inject = [ '$scope', '$log', '$mdDialog', 'eAction', '$http', 'projectSV', '$location', 'executeJSTemplateSV',
			'executeJSProjectSV', 'executeJSConsoleSV' ];

	/**
	 * 
	 * @param $scope
	 * @param $log
	 * @returns
	 */
	function ActionCT($scope, $log, $mdDialog, eAction, $http, projectSV, $location, executeJSTemplateSV, executeJSProjectSV,
			executeJSConsoleSV) {
		$log.debug('[ActionCT] Inicializando...');
		var self = this;

		var origin = new URI($location.absUrl());

		var editors = {};

		self.cancel = cancel;

		self.load = load;

		self.options = {};

		self.values = {};

		self.execute = execute;

		init();

		function init() {

		}

		function cancel() {
			$mdDialog.cancel();
		}

		function load(id, endpoint) {
			$log.debug('[ActionCT] ProjectName: ' + projectSV.getSelectedProject().name);
			var loadURL = origin.segment([ "skdev", "api", "projects", projectSV.getSelectedProject().name, endpoint ]).href();
			$log.debug('[ActionCT] load: ' + loadURL);
			$http.get(loadURL).then(function(res) {
				self.options[id] = res.data;
			});
		}

		function execute() {
			var parentEl = angular.element(document.body);
			$mdDialog.show({
				parent : parentEl,
				templateUrl : '/skdev/partials/action.console.dialog.html',
				controller : 'ActionConsoleCT',
				controllerAs : 'actionConsoleCT',
				clickOutsideToClose : false,
				onComplete : function(scope, element) {
					$log.debug('[ActionCT] execute');

					/*
					 * Inicializa as variáveis do executeJS
					 */
					executeJSTemplateSV.setTemplates(eAction.templates);
					var $values = self.values;
					var $template = executeJSTemplateSV;
					var $project = executeJSProjectSV;
					var $console = executeJSConsoleSV;

					var executeFn = new Function('$values', '$template', '$project', '$console', eAction.executeJS);
					angular.bind(this, executeFn, $values, $template, $project, $console)();
				}
			});
		}
	}
})();
